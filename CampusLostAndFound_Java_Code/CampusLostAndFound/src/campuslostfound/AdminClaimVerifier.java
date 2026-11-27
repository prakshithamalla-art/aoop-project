package campuslostfound;
import java.util.Objects;
public final class AdminClaimVerifier implements ClaimVerifier {
 public VerificationResult verify(Claim claim){
  Objects.requireNonNull(claim,"Claim required");
  boolean sufficient=claim.evidence().trim().length()>=5;
  return new VerificationResult(sufficient,sufficient?"Evidence reviewed":"Evidence is insufficient");
 }
}
