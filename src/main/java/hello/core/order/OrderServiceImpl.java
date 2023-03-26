package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//생성자를 하나만 쓰고, @Autowired도 생략하고 Lombok을 사용함으로써 코드를 간결하게 만들어줌
@RequiredArgsConstructor        //이 친구가 생성자 주입을 자동으로 진행해줌(final 또는 @NotNull일 때)
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    필드 주입
//    효율 별로 안 좋음
//    @Autowired
//    private final MemberRepository memberRepository;
//    @Autowired
//    private final DiscountPolicy discountPolicy;


    //수정자 주입(setter)
    //선택 및 변경 가능성이 있는 의존 관계에서 사용
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    //생성자를 통해 어떤 구현 객체가 주입될지 알 수 없음
    //주입 객체 종류는 외부에서(AppConfig 클래스)에서 결정 --> 기능을 실행하는 책임에만 집중 가능

    //생성자 주입 ( 생성사 호출 시점에 1회만 호출되는 것이 보장됨)
    /* 불변하거나 필수적인 의존 관계에서 사용 */
    /* 생성자가 1개만 있을 경우 @Autowired 생략해도 자동 주입됨 */
    //@Autowired
//    public OrderServiceImpl(MemberRepository memberRepository,
//                            @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

//    public OrderServiceImpl() {
//    }

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
