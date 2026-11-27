package campuslostfound;
import java.util.Objects;
public final class SaboteurClaimVerifier implements ClaimVerifier {
 // Deliberately wrong: approves every claim without checking evidence.
 public VerificationResult verify(Claim claim){Objects.requireNonNull(claim); return new VerificationResult(true,"Approved without checking");}
}
