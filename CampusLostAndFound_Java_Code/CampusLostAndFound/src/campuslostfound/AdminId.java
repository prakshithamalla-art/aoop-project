package campuslostfound;
import java.util.Objects;
public record AdminId(String value) {
 public AdminId { Objects.requireNonNull(value); value=value.trim(); if(value.isEmpty()) throw new IllegalArgumentException("Blank admin ID"); }
}
