package campuslostfound;
import java.util.Objects;
public final class EvidenceClaimVerifier implements ClaimVerifier {
 public VerificationResult verify(Claim claim){Objects.requireNonNull(claim,"Claim required"); if(claim.evidence().length()>=5)return new VerificationResult(true,"Evidence is sufficient"); return new VerificationResult(false,"Evidence is too short");}
}
