package campuslostfound;
import java.util.Objects;
public final class Claim {
 private final ClaimId id; private final StudentId studentId; private final FoundItemId itemId; private final String evidence; private ClaimStatus status;
 public Claim(ClaimId id,StudentId studentId,FoundItemId itemId,String evidence){this.id=Objects.requireNonNull(id);this.studentId=Objects.requireNonNull(studentId);this.itemId=Objects.requireNonNull(itemId);Objects.requireNonNull(evidence);this.evidence=evidence.trim();if(this.evidence.isEmpty())throw new IllegalArgumentException("Evidence required");status=ClaimStatus.PENDING;}
 public ClaimId id(){return id;} public StudentId studentId(){return studentId;} public FoundItemId itemId(){return itemId;} public String evidence(){return evidence;} public ClaimStatus status(){return status;}
 public void approve(){if(status!=ClaimStatus.PENDING)throw new IllegalStateException("Only pending claim can be approved");status=ClaimStatus.APPROVED;}
 public void reject(){if(status!=ClaimStatus.PENDING)throw new IllegalStateException("Only pending claim can be rejected");status=ClaimStatus.REJECTED;}
 public String toString(){return "Claim "+id.value()+" | "+studentId.value()+" | "+itemId.value()+" | "+status;}
}
