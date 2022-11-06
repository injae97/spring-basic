package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    /* 해당 인터페이스만 의존 (DIP 위배 X) */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /**
     * 생성자(Constructor)를 생성한 후 AppConfig에서 설정
     * 즉 구조는 OrderServiceImpl -> AppConfig(생성자 주입) -> memberRepository, discountPolicy 할당
     */
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 주문 결과 반환
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); /* 회원 정보 조회 */
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
