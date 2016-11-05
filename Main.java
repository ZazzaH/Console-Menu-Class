import java.util.*;
import java.io.IOException;

class Main
{
    public static void main(String[] args)
    {
        Menu myMenu = new Menu(5);
        myMenu.setOption(1, "Test");
        myMenu.setOption(2, "Test");
        myMenu.setOption(3, "Test");
        myMenu.setOption(4, "Test");
        myMenu.setOption(5, "Test");
        int option = myMenu.userInput();
    }
}

class Menu
{
    
    private final int totalOptionsNum;
    private List<String> optionList = new ArrayList<String>();
    
    public Menu(int options)
    {
        this.totalOptionsNum = options;
        for(int i = 0; i < this.totalOptionsNum; i++)
        {
            String optionGen = (i+1) + ". Generic Option";
            this.optionList.add(optionGen);
        }
    }
    
    public void setOption(int optionNum, String optionDesc)
    {
        optionNum -= 1;
        if(optionNum >= this.totalOptionsNum || optionNum < 0)
        {
            return;
        }
        else
        {
            String optionGen = (optionNum+1) + ". " + optionDesc;
            this.optionList.set(optionNum, optionGen);
        }
    }
    
    private String getOption(int optionNum)
    {
        optionNum -= 1;
        String option = optionList.get(optionNum);
        return option;
    }
    
    private String getAllOptions()
    {
        String optionList = "";
        int count = 0;
        for(String option : this.optionList)
        {
            optionList += option;
            if(count != this.totalOptionsNum-1)
            {
                optionList += "\n";   
            }
            count++;
        }
        return optionList;
    }
    
    public int userInput()
    {
        System.out.println(this.getAllOptions());
        System.out.print("Inserisci un'opzione: ");
        Scanner reader = new Scanner(System.in);
        int option = 1;
        Boolean execute = true;
        while(execute == true)
        {
            try
            {
                while(!reader.hasNextInt()) 
                {
                    System.out.println("Input invalido.");
                    System.out.print("Inserire nuovamente l'opzione: ");
                    reader.next();
                }
                option = reader.nextInt();   
                option -= 1;
                
                if(option >= this.totalOptionsNum || option < 0)
                {
                    throw new IOException();
                }
                else
                {
                    execute = false;
                    return option;
                }
            }
            catch(Exception e)
            {
                System.out.println("Opzione inesistente.");
                System.out.print("Inserire nuovamente l'opzione: ");
            }
        }
        return 0;
    }
}