package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import hello.hellospring.service.MemberService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    //setter 주입
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createFrom(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberFrom from){
        Member member = new Member();
        member.setName(from.getName());

        memberService.join(member);

        return "redirect:/";
    }
    
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

    //setter 주입
//    private MemberService memberService;
//
//    @Autowired
//    public void MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }

    //필드주입   필드를 바로 주입시켜주는 것. 단점 : 바꿀 수 있는 방법이 없다(활용 불가)
    //@Autowired private MemberService memberService;

    //생성자 주입 : 생성자에게  di(디펜던시 인젝션) 하는 법
//    private final MemberService memberService;
//    @Autowired //Dependency injection(의존성 주입)
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
}
