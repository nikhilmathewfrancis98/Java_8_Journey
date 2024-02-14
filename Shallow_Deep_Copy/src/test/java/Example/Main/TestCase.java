package Example.Main;


import Example.POJO.Address;
import Example.POJO.User;
import org.junit.Test;

;import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class TestCase {

    @Test
    public void testFindMax(){
        Address address = new Address("Downing St 10", "London", "England");
        Address address1=new Address("Sea view ","Alappuzha","India");
        User pm = new User("Prime", "Minister", address);
        //This is not exactly the shallow copy here we are creating the new instance
        // but is we do some changes to address via pm and shallow and directly with address its reflecting because
        // address is common for both instances
        User shallowCopy = new User(
                pm.getFirstName(), pm.getLastName(), pm.getAddress());// or  User shallowCopy = pm; // Still doubt this should have different hashcode
        System.out.println(shallowCopy.getAddress().getCountry()+"\t"+pm.getAddress().getCountry());

        address.setCountry("Great Britain");
        assertTrue(pm.equals(shallowCopy));
        System.out.println(pm.hashCode()+" "+shallowCopy.hashCode());
        System.out.println(shallowCopy.getAddress().getCountry()+"\t"+pm.getAddress().getCountry());
//        assertEquals(shallowCopy.getAddress().getCountry(),pm.getAddress().getCountry());
          assertEquals(pm.hashCode(),shallowCopy.hashCode()); // Both shallow and pm are not equal
        pm.setLastName("Francis");
        shallowCopy.setLastName("Mathew");
        System.out.println(shallowCopy.getLastName()+"\t"+pm.getLastName());
        // Just reversing the call
//        shallowCopy.getAddress().setCity("Alappuzha");
//        System.out.println(shallowCopy.getAddress().getCity()+"\t"+pm.getAddress().getCity()+"\t"+address.getCity());
       shallowCopy.setFirstName("Nikhil");

        System.out.println(shallowCopy.getFirstName()+"\t"+pm.getFirstName());


        shallowCopy.setAddress(address1);
        System.out.println( shallowCopy.getAddress().getCity()+"\t"+ pm.getAddress().getCity());


    }
}
