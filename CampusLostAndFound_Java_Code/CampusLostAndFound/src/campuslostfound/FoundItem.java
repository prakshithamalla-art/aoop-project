package campuslostfound;
import java.time.LocalDate; import java.util.Objects;
public final class FoundItem {
 private final FoundItemId id; private final StudentId reporter; private final ItemDescription description; private final Location foundAt; private final LocalDate foundDate; private ItemStatus status;
 public FoundItem(FoundItemId id,StudentId reporter,ItemDescription description,Location foundAt,LocalDate foundDate){this.id=Objects.requireNonNull(id);this.reporter=Objects.requireNonNull(reporter);this.description=Objects.requireNonNull(description);this.foundAt=Objects.requireNonNull(foundAt);this.foundDate=Objects.requireNonNull(foundDate);if(foundDate.isAfter(LocalDate.now()))throw new IllegalArgumentException("Found date cannot be in future");status=ItemStatus.AVAILABLE;}
 public FoundItemId id(){return id;} public StudentId reporter(){return reporter;} public ItemDescription description(){return description;} public Location foundAt(){return foundAt;} public LocalDate foundDate(){return foundDate;} public ItemStatus status(){return status;}
 public void markClaimPending(){if(status!=ItemStatus.AVAILABLE)throw new IllegalStateException("Item is not available");status=ItemStatus.CLAIM_PENDING;}
 public void makeAvailableAgain(){if(status!=ItemStatus.CLAIM_PENDING)throw new IllegalStateException("Item has no pending claim");status=ItemStatus.AVAILABLE;}
 public void markReturned(){if(status!=ItemStatus.CLAIM_PENDING)throw new IllegalStateException("Item has no pending claim");status=ItemStatus.RETURNED;}
 public String toString(){return "FOUND "+id.value()+" | "+description+" | "+foundAt+" | "+status;}
}
