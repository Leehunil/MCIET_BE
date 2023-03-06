package gdsc.MCIET.domain.memo.service;

import gdsc.MCIET.domain.memo.domain.Memo;
import gdsc.MCIET.domain.memo.domain.repository.MemoRepository;
import gdsc.MCIET.domain.memo.exception.MemoNotFound;
import gdsc.MCIET.domain.memo.presentaion.dto.request.SaveMemoDto;
import gdsc.MCIET.domain.memo.presentaion.dto.request.UpdateCheckBoxDto;
import gdsc.MCIET.domain.memo.presentaion.dto.response.ShowMemoDto;
import gdsc.MCIET.domain.user.domain.User;
import gdsc.MCIET.global.utils.UserUtilsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MemoService implements MemoUtils{

    private final MemoRepository memoRepository;
    private final UserUtilsImpl userUtils;

    //메모 저장
    @Transactional
    public Long saveMemo(SaveMemoDto saveMemoDto){
        User user = userUtils.findUser(saveMemoDto.getEmail());
        return memoRepository.save(Memo.builder()
                .user(user)
                .contents(saveMemoDto.getContents())
                .checkBox(false)
                .build()
        ).getId();
    }

    //저장된 메모 보여주기
    public List<ShowMemoDto> showAllMemo(String email){
        User user = userUtils.findUser(email);
        List<Memo> memoList = memoRepository.findByUser(user);
        return memoList.stream()
                .map(memo -> new ShowMemoDto(memo))
                .collect(Collectors.toList());
    }

    //메모 체크박스 업데이트
    @Transactional
    public void updateCheckBox(UpdateCheckBoxDto updateCheckBoxDto){
        Memo memo = findMemo(updateCheckBoxDto.getMemoId());
        memo.updateCheck(updateCheckBoxDto.getCheckBox());
    }

    //메모 삭제
    public void deleteMemo(Long memoId){
        Memo memo = findMemo(memoId);
        memoRepository.delete(memo);
    }

    @Override
    public Memo findMemo(Long memoId) {
        return memoRepository.findById(memoId).orElseThrow(() -> MemoNotFound.EXCEPTION);
    }
}
