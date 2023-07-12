package coen6717.unittest.examples;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

//import org.junit.Test;

import coen6761.unittest.examples.User;


 
public class TestUserException {

 
    @Test
    public void testUsernameIsNull() {
         
    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
             
            @Override
            public void execute() throws Throwable {
                User user = new User();
                user.setName(null);
            }
        }, "Username cannot be blank");
    	Assertions.assertEquals("Username cannot be blank", thrown.getMessage());
    }
    
    
    @Test
    public void testUsernameTooShort() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    User user = new User();
                    user.setName("Jo");
                }
        );
     
        Assertions.assertEquals("Username is too short", exception.getMessage());     
    }
    
    @Test
    public void testUsernameTooLong() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    User user = new User();
                    user.setName("Pablo Diego Jose Franciso Picasso");
                }
        );
     
        assertEquals("Username is too long", exception.getMessage());      
    }
    @Test
    public void testUsernameEmpty() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    User user = new User();
                    user.setName(null);
                }
        );
     
        Assertions.assertEquals("Username should not be blank", exception.getMessage());      
    }
}