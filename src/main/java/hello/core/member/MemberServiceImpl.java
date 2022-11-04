package hello.core.member;

public class MemberServiceImpl implements MemberService {

    /**
     * MemberServiceImpl  ->  MemberRepository 접근 후
     * memberRepository 변수명으로 new MemoryMemberRepository() 할당
     * 즉 구조는 MemberServiceImpl ->  MemberRepository(interface) -> MemoryMemberRepository(class)
     */
    private final MemberRepository memberRepository = new MemoryMemberRepository();

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
