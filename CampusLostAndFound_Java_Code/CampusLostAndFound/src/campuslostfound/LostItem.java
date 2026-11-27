package campuslostfound;
import java.time.LocalDate; import java.util.Objects;
public final class LostItem {
 private final LostItemId id; private final StudentId reporter; private final ItemDescription description; private final Location lastSeen; private final LocalDate lostDate;
 public LostItem(LostItemId id,StudentId reporter,ItemDescription description,Location lastSeen,LocalDate lostDate){this.id=Objects.requireNonNull(id);this.reporter=Objects.requireNonNull(reporter);this.description=Objects.requireNonNull(description);this.lastSeen=Objects.requireNonNull(lastSeen);this.lostDate=Objects.requireNonNull(lostDate);if(lostDate.isAfter(LocalDate.now()))throw new IllegalArgumentException("Lost date cannot be in future");}
 public LostItemId id(){return id;} public StudentId reporter(){return reporter;} public ItemDescription description(){return description;} public Location lastSeen(){return lastSeen;} public LocalDate lostDate(){return lostDate;}
 public String toString(){return "LOST "+id.value()+" | "+description+" | "+lastSeen;}
}
