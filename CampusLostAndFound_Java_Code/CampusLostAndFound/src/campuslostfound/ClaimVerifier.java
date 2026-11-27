package campuslostfound;
public interface ClaimVerifier {
 // Pre: claim is non-null. Post: a non-null result is returned; claim is not mutated.
 VerificationResult verify(Claim claim);
}
