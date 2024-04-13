package st10085622_prog5121_poe_p1;

public class userData {
  
  private static String firstName, lastName, userName, password; //by making private, I restrict access to it so it cannot be changed later on in the prgram
    
  //getter and setter for name
  public void setName(String name){
    this.firstName = name;
  }
  public String getName(){
    return firstName;     
  }
  
  //getters and setters for surname
  public void setSurname(String surname){
      this.lastName = surname;
  }
  public String getSurname(){
    return lastName;        
  }
  
  //getter and setter for username
  public void setUsername(String username){
      this.userName = username;
  }
  public String getUsername(){
    return userName;         
  }

//getter and setter for password
  public void setPassword(String password){
      this.password = password;
  }
  public String getPassword(){
     return password;
  }
  
  
  
  
  
  
  
  
  
          
}
