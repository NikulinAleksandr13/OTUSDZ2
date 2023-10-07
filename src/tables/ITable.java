package tables;

import java.util.List;
import java.util.Map;

public interface ITable {
 void create(List<String> columns);
 void delete();

}
