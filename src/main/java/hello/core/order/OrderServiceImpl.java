package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    //인터페이스에만 의존하도록 코드 수정(DIP 원칙 유지)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //생성자를 통해 어떤 구현 객체가 주입될지 알 수 없음
    //주입 객체 종류는 외부에서(AppConfig 클래스)에서 결정 --> 기능을 실행하는 책임에만 집중 가능
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //only for test
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
