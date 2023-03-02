package gdsc.MCIET.domain.memo.service;

import gdsc.MCIET.domain.memo.domain.Memo;
import gdsc.MCIET.domain.memo.domain.repository.MemoRepository;
import gdsc.MCIET.domain.memo.presentaion.dto.request.SaveMemoDto;
import gdsc.MCIET.domain.user.domain.User;
import gdsc.MCIET.global.utils.UserUtilsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;
    private final UserUtilsImpl userUtils;

    //메모 저장
    @Transactional
    public Long saveMemo(SaveMemoDto saveMemoDto){
        User user = userUtils.findUser(saveMemoDto.getEmail());
        Long memoId = memoRepository.save(Memo.builder()
                .user(user)
                .contents(saveMemoDto.getContents())
                .build()
        ).getId();
        return memoId;
    }

//    //저장된 메모 보여주기
//    public List<ShowMemoDto> showAllMemo(String email){
//        User user = userUtils.findUser(email);
//        List<Memo> memoList = memoRepository.findByUser(user);
//    }
}
