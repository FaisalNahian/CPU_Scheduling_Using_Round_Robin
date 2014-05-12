import java.io.File;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Simulator
{
  private static Scanner keyboard = new Scanner(System.in);

  public static int getNumberOfProcesses()
  {
    for (;;)
    {
      System.out.print("Number of processes to create (greater than 0): ");
      String tempCount = keyboard.nextLine();
      try
      {
        int count = Integer.parseInt(tempCount);
        if (count <= 0) {
          throw new Exception();
        }
        return count;
      }
      catch (Exception error)
      {
        System.out.println("Invalid value. Please try again.");
      }
    }
  }

  public static int getMinimumQuantumTime()
  {
    for (;;)
    {
      System.out.print("Minimum quantum time (greater than 0): ");
      String tempCount = keyboard.nextLine();
      try
      {
        int count = Integer.parseInt(tempCount);
        if (count <= 0) {
          throw new Exception();
        }
        return count;
      }
      catch (Exception error)
      {
        System.out.println("Invalid value. Please try again.");
      }
    }
  }

  public static int getMaximumQuantumTime(int minimumQuantumTime)
  {
    for (;;)
    {
      System.out.print("Maximum quantum time (greater than " + minimumQuantumTime + "): ");
      String tempCount = keyboard.nextLine();
      try
      {
        int count = Integer.parseInt(tempCount);
        if ((count <= 0) || (count <= minimumQuantumTime)) {
          throw new Exception();
        }
        return count;
      }
      catch (Exception error)
      {
        System.out.println("Invalid value. Please try again.");
      }
    }
  }

  public static int getMaximumArrivalTime()
  {
    for (;;)
    {
      System.out.print("Maximum arrival time (greater than 0): ");
      String tempMax = keyboard.nextLine();
      try
      {
        int max = Integer.parseInt(tempMax);
        if (max <= 0) {
          throw new Exception();
        }
        return max;
      }
      catch (Exception error)
      {
        System.out.println("Invalid value. Please try again.");
      }
    }
  }

  public static int getTimeSlice()
  {
    for (;;)
    {
      System.out.print("Time slice (greater than 0): ");
      String tempSlice = keyboard.nextLine();
      try
      {
        int timeSlice = Integer.parseInt(tempSlice);
        if (timeSlice <= 0) {
          throw new Exception();
        }
        return timeSlice;
      }
      catch (Exception error)
      {
        System.out.println("Invalid value. Please try again.");
      }
    }
  }

  public static int getOutputDestination()
  {
    for (;;)
    {
      System.out.println("Output Configuration");
      System.out.println("[1] Output to console.");
      System.out.println("[2] Output to file.");

      System.out.print("Option: ");
      int choice = keyboard.nextInt();
      keyboard.nextLine();
      if ((choice == 1) || (choice == 2)) {
        return choice;
      }
      System.out.println("Invalid choice. Please try again.");
    }
  }

  public static void main(String[] args)
  {
    for (;;)
    {
      System.out.println(" ");
      System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
      System.out.println("+ CPU Scheduling using Round Robin Algorithm Menu +");
      System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
      System.out.println(" ");
      System.out.println("[1] Enter 1 to Simulate Round Robin from a text file.");
      System.out.println("[2] Enter 2 to Simulate Round Robin with random generated processes.");
      System.out.println("[3] Enter 3 to Exit");

      System.out.print("Option: ");
      int choice = keyboard.nextInt();
      keyboard.nextLine();
      if (choice == 3) {
        break;
      }
      LinkedList<Process> processes = null;
      if (choice == 1)
      {
        System.out.print("Enter the filename (example: processes.txt): ");
        processes = ProcessCreator.getProcessFromFile(keyboard.nextLine());
      }
      else if (choice == 2)
      {
        int numberOfProcesses = getNumberOfProcesses();
        int minimumQuantumTime = getMinimumQuantumTime();
        int maximumQuantumTime = getMaximumQuantumTime(minimumQuantumTime);
        int maximumArrivalTime = getMaximumArrivalTime();

        processes = ProcessCreator.generateRandomProcesses(numberOfProcesses, minimumQuantumTime, maximumQuantumTime, maximumArrivalTime);
      }
      else
      {
        System.out.println("Invalid choice.");
      }
      if ((processes != null) && (processes.size() != 0))
      {
        int timeSlice = getTimeSlice();


        PrintStream ps = null;

        int outputTo = getOutputDestination();
        if (outputTo == 1)
        {
          ps = System.out;
        }
        else if (outputTo == 2)
        {
          System.out.print("Enter filename for output (example: result): ");
          String fileName = keyboard.nextLine();
          try
          {
            ps = new PrintStream(new File(fileName));
          }
          catch (Exception error)
          {
            System.out.println("Failed to open file for output.");
          }
          continue;
        }
        RoundRobinSimulator rr = new RoundRobinSimulator();
        rr.simulate();

        System.out.println("Simulation Finished!");
        if (outputTo == 2) {
          ps.close();
        }
      }
    }
  }
}
