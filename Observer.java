package Chef;

import Composite.MenuItem;

import java.util.List;

public interface Observer {
    public void update(List<MenuItem> obj);
}
