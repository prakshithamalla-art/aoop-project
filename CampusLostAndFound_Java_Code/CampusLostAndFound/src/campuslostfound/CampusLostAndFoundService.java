package campuslostfound;
import java.time.LocalDate; import java.util.*;
public final class CampusLostAndFoundService {
 private final Map<StudentId,Student> students=new HashMap<>();
 private final Map<LostItemId,LostItem> lostItems=new LinkedHashMap<>();
 private final Map<FoundItemId,FoundItem> foundItems=new LinkedHashMap<>();
 private final Map<ClaimId,Claim> claims=new LinkedHashMap<>();
 private int lostNo=1,foundNo=1,claimNo=1;
 public void registerStudent(Student s){Objects.requireNonNull(s);if(students.putIfAbsent(s.id(),s)!=null)throw new IllegalArgumentException("Student already registered");}
 public LostItem reportLostItem(StudentId sid,ItemDescription d,Location l,LocalDate date){requireStudent(sid);LostItem x=new LostItem(new LostItemId("L"+lostNo++),sid,d,l,date);lostItems.put(x.id(),x);return x;}
 public FoundItem reportFoundItem(StudentId sid,ItemDescription d,Location l,LocalDate date){requireStudent(sid);FoundItem x=new FoundItem(new FoundItemId("F"+foundNo++),sid,d,l,date);foundItems.put(x.id(),x);return x;}
 public List<FoundItem> searchFoundItems(String keyword){Objects.requireNonNull(keyword);String q=keyword.trim().toLowerCase(Locale.ROOT);if(q.isEmpty())throw new IllegalArgumentException("Search keyword required");return foundItems.values().stream().filter(x->x.status()!=ItemStatus.RETURNED).filter(x->x.description().toString().toLowerCase(Locale.ROOT).contains(q)).toList();}
 public Claim submitClaim(StudentId sid,FoundItemId fid,String evidence){requireStudent(sid);FoundItem item=foundItems.get(Objects.requireNonNull(fid));if(item==null)throw new IllegalArgumentException("Found item does not exist");if(item.status()!=ItemStatus.AVAILABLE)throw new IllegalStateException("Item is not available");Claim c=new Claim(new ClaimId("C"+claimNo++),sid,fid,evidence);item.markClaimPending();claims.put(c.id(),c);return c;}
 public void approveClaim(ClaimId cid,Admin admin,ClaimVerifier verifier){Objects.requireNonNull(admin);Objects.requireNonNull(verifier);Claim c=requireClaim(cid);if(c.status()!=ClaimStatus.PENDING)throw new IllegalStateException("Claim is not pending");FoundItem item=foundItems.get(c.itemId());if(item==null||item.status()!=ItemStatus.CLAIM_PENDING)throw new IllegalStateException("Item is not pending");VerificationResult result=Objects.requireNonNull(verifier.verify(c),"Verifier must return a result");if(!result.approved())throw new IllegalArgumentException("Verification failed: "+result.message());c.approve();item.markReturned();}
 public void rejectClaim(ClaimId cid,Admin admin){Objects.requireNonNull(admin);Claim c=requireClaim(cid);if(c.status()!=ClaimStatus.PENDING)throw new IllegalStateException("Claim is not pending");FoundItem item=foundItems.get(c.itemId());c.reject();if(item!=null&&item.status()==ItemStatus.CLAIM_PENDING)item.makeAvailableAgain();}
 public List<LostItem> lostItems(){return List.copyOf(lostItems.values());} public List<FoundItem> foundItems(){return List.copyOf(foundItems.values());} public List<Claim> claims(){return List.copyOf(claims.values());}
 private void requireStudent(StudentId id){Objects.requireNonNull(id);if(!students.containsKey(id))throw new IllegalArgumentException("Student not registered");}
 private Claim requireClaim(ClaimId id){Objects.requireNonNull(id);Claim c=claims.get(id);if(c==null)throw new IllegalArgumentException("Claim not found");return c;}
}
