//package gdsc.MCIET.global.security.auth;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.ToString;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//@AllArgsConstructor
//@Getter
//@ToString
//public class AuthUser implements UserDetails {
//
//    private final Long id;
//    private final String email;
//
//    //계정의 권한 목록을 리턴
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    //계정의 비밀번호를 리턴
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    //계정의 고유한 값을 리턴
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    //계정의 만료 여부 리턴
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    //계정의 잠김 여부 리턴
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    //비밀번호 만류 여부 리턴
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    //계정의 활성화 여부 리턴
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
