package campuslostfound;
public record VerificationResult(boolean approved,String message) {
 public VerificationResult {if(message==null||message.isBlank())throw new IllegalArgumentException("Message required");}
}
