package campuslostfound;
import java.util.Objects;
public record FoundItemId(String value) {
 public FoundItemId { Objects.requireNonNull(value); value=value.trim(); if(value.isEmpty()) throw new IllegalArgumentException("Blank found item ID"); }
}
