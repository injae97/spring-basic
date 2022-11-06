package hello.core.member;

public class MemberServiceImpl implements MemberService {

    /* 해당 인터페이스만 의존 (DIP 위배 X) */
    private final MemberRepository memberRepository;

    /**
     * 생성자(Constructor)를 생성한 후 AppConfig에서 설정
     * 즉 구조는 MemberServiceImpl -> AppConfig(생성자 주입) -> MemoryMemberRepository 할당
     */
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    /**
     * 회원 조회
     */
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
