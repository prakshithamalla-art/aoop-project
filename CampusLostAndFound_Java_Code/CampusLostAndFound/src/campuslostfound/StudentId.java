package campuslostfound;
import java.util.Objects;
public record StudentId(String value) {
 public StudentId { Objects.requireNonNull(value); value=value.trim(); if(value.isEmpty()) throw new IllegalArgumentException("Blank student ID"); }
}
