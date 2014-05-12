import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.LinkedList;
// Simlating from a file
public class ProcessCreator
{
  public static LinkedList<Process> getProcessFromFile(String filename)
  {
    LinkedList<Process> processes = new LinkedList();
    try
    {
      BufferedReader br = new BufferedReader(new FileReader(filename));
      String line = br.readLine();


      line = br.readLine();
      while (line != null)
      {
        String[] tokens = line.split(" ");

        String processName = tokens[0];
        int arrivalTime = Integer.parseInt(tokens[1]);
        int quantumTime = Integer.parseInt(tokens[2]);

        processes.add(new Process(processName, arrivalTime, quantumTime));

        line = br.readLine();
      }
    }
    catch (Exception error)
    {
      System.out.println("Unable to load the file. The file path may be invalid or the file format is invalid.");
    }
    return processes;
  }

  public static LinkedList<Process> generateRandomProcesses(int numberOfProcesses, int minimumQuantumTime, int maximumQuantumTime, int maximumArrivalTime)
  {
    LinkedList<Process> processes = new LinkedList<Process>();
    for (int i = 0; i < numberOfProcesses; i++) {
      processes.add(new Process("P" + i, randomInRange(1, maximumArrivalTime), randomInRange(minimumQuantumTime, maximumQuantumTime)));
    }
    return processes;
  }

  private static int randomInRange(int bound1, int bound2)
  {
    int min = Math.min(bound1, bound2);
    int max = Math.max(bound1, bound2);
    return min + (int)(Math.random() * (max - min + 1));
  }
}