package campuslostfound;
import java.util.Objects;
public record Location(String building, String area) {
 public Location { Objects.requireNonNull(building); Objects.requireNonNull(area); building=building.trim(); area=area.trim(); if(building.isEmpty()||area.isEmpty()) throw new IllegalArgumentException("Location fields cannot be blank"); }
 public String toString(){ return building+" - "+area; }
}
