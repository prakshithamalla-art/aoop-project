package campuslostfound;
import java.util.Objects;
public record LostItemId(String value) {
 public LostItemId { Objects.requireNonNull(value); value=value.trim(); if(value.isEmpty()) throw new IllegalArgumentException("Blank lost item ID"); }
}
