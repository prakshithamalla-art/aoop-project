package campuslostfound;
import java.util.Objects;
public record ClaimId(String value) {
 public ClaimId { Objects.requireNonNull(value); value=value.trim(); if(value.isEmpty()) throw new IllegalArgumentException("Blank claim ID"); }
}
