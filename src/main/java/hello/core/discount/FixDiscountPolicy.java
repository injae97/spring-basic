package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 고정 할인 : 1000원

    /**
     * 1000원 할인 로직
     */
    @Override
    public int discount(Member member, int price) {
        /* enum type은 == 로 접근 */
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        else {
            return 0;
        }
    }
}
