package com.revature.data;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.revature.beans.Employee;
import org.junit.jupiter.api.*;
import com.revature.beans.EventType;
import com.revature.utils.DAOFactory;

public class EventTypeDAOTest {

    private EventTypeDAO eDao = DAOFactory.getEventTypeDAO();


    @Test
    public void getByIdNotNull()
    {
        EventType ev = new EventType();
        ev.setEventId(1);
        assertNotNull(eDao.getById(1));
    }

    @Test
    public void getByIdNull()
    {
        assertNull(eDao.getById(85));
    }

    @Test
    public void getAllNotNull()
    {
        assertNotNull(eDao.getAll());
    }

    @Test
    public void getByNameNotNull()
    {
        EventType ev = new EventType();
        ev.setEventId(1);
        ev.setName("play");
        assertNotNull(eDao.getByName("play"));
    }


    @Test
    public void getByNameNull()
    {
        assertTrue(eDao.getByName("party").isEmpty());
    }

}
