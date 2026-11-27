package campuslostfound;
public class ContractTests {
 public static void main(String[] args){
  Claim good=new Claim(new ClaimId("C1"),new StudentId("S1"),new FoundItemId("F1"),"Blue sticker on back");
  Claim weak=new Claim(new ClaimId("C2"),new StudentId("S1"),new FoundItemId("F2"),"x");
  ClaimVerifier[] implementations={new EvidenceClaimVerifier(),new AdminClaimVerifier()};
  for(ClaimVerifier verifier:implementations) runSharedContract(verifier,good,weak);
  try {
   runSharedContract(new SaboteurClaimVerifier(),good,weak);
   throw new AssertionError("Saboteur was not caught");
  } catch(AssertionError expected) {
   if ("Saboteur was not caught".equals(expected.getMessage())) throw expected;
   System.out.println("Saboteur correctly caught: "+expected.getMessage());
  }
  System.out.println("All valid implementations passed the shared contract tests.");
 }
 private static void runSharedContract(ClaimVerifier verifier,Claim good,Claim weak){
  VerificationResult valid=verifier.verify(good);
  check(valid!=null,"Verifier must return a result");
  check(valid.approved(),"Sufficient evidence must be accepted");
  VerificationResult invalid=verifier.verify(weak);
  check(invalid!=null,"Verifier must return a result for weak evidence");
  check(!invalid.approved(),"Insufficient evidence must be rejected");
 }
 private static void check(boolean ok,String message){if(!ok)throw new AssertionError(message);}
}
