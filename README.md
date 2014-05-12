CPU_Scheduling_Using_Round_Robin
================================

Calculate average waiting time, average turnaround time, CPU utilization, and Throughput

Round Robin Scheduling Read Me

Round Robin Scheduling is a preemptive version of first-come, first-served scheduling. Processes are dispatched in a first-in-first-out sequence but each process is allowed to run for only a limited amount of time. This time interval is known as a time-slice or quantum. If a process does not complete or get blocked because of an I/O operation within the time slice, the time slice expires and the process is preempted. Process gets blocked because of an I/O operation), it is then preempted. This preempted process is placed at the back of the run queue where it must wait for the processes that were already on the list to cycle through the CPU.

With round robin scheduling, interactive performance depends on the length of the quantum and the number of processes in the run queue. A very long quantum makes the algorithm behave very much like first come, first served scheduling since it’s very likely that a process with block or complete before the time slice is up. A small quantum lets the system cycle through processes quickly. This is wonderful for interactive processes. Unfortunately, there is an overhead to context switching and having to do so frequently increases the percentage of system time that is used on context switching rather than real work.

 

Advantage: Round robin scheduling is fair in that every process gets an equal share of the CPU. The main advantage of round robin algorithm over first come first serve algorithm is that it is starvation free. It is easy to implement and, if we know the number of processes on the run queue, we can know the worst-case response time for a process.

Disadvantage: Giving every process an equal share of the CPU is not always a good idea. For instance, highly interactive processes will get scheduled no more frequently than CPU-bound processes.

Round robin algorithm is simple and easy to implement. The name round robin comes from the principle known as round robin in which every person takes equal share of something in turn.


Pseudo Code: 

1.	CPU scheduler picks the process from the circular/ready queue, set a timer to interrupt it after 1 time slice/quantum and dispatches it.

2.	If  process has burst time less than 1 time slice/quantum
                
        	Process will leave the CPU after the completion
        	CPU will proceed with the next process in the ready queue/circular queue.
  
    else If process has burst time longer than 1 time slice/quantum

        	Timer will be stopped. It cause interruption to the OS.
        	Executed process is then placed at the tail of the circular/ready queue by applying  the context switch
        	CPU scheduler then proceeds by selecting the next process in the ready queue.          

User can calculate the average turnaround time and average waiting time along with the starting and finishing time of each process

Turnaround time: It’s the total time taken by the process between starting and the completion

Waiting time: It’s the time for which process is ready to run but not executed by CPU scheduler

CPU Utilization: It’s the computer's usage of processing resources, or the amount of work handled by a CPU. Actual CPU utilization varies depending on the amount and type of managed computing tasks. Certain tasks require heavy CPU time, while others require less because of non-CPU resource requirements.

Throughput: It’s the amount of material or items passing through a system or process.


Below is an example of the result after we execute the round robin algorithm and using time slice 5: 
 
ROUND ROBIN SIMULATION RESULT
Time Slice: 5

PROCESSES
Process Name, Arrival Time, Time Quantum
p1, 0, 5
p2, 5, 20
p3, 6, 12
p4, 8, 14
p5, 10, 3

TIME 0 : p1
TIME 1 : p1
TIME 2 : p1
TIME 3 : p1
TIME 4 : p1
TIME 5 : p2
TIME 6 : p2
TIME 7 : p2
TIME 8 : p2
TIME 9 : p2
--switch--
TIME 10 : p3
TIME 11 : p3
TIME 12 : p3
TIME 13 : p3
TIME 14 : p3
--switch--
TIME 15 : p4
TIME 16 : p4
TIME 17 : p4
TIME 18 : p4
TIME 19 : p4
--switch--
TIME 20 : p2
TIME 21 : p2
TIME 22 : p2
TIME 23 : p2
TIME 24 : p2
--switch--
TIME 25 : p5
TIME 26 : p5
TIME 27 : p5
TIME 28 : p3
TIME 29 : p3
TIME 30 : p3
TIME 31 : p3
TIME 32 : p3
--switch--
TIME 33 : p4
TIME 34 : p4
TIME 35 : p4
TIME 36 : p4
TIME 37 : p4
--switch--
TIME 38 : p2
TIME 39 : p2
TIME 40 : p2
TIME 41 : p2
TIME 42 : p2
--switch--
TIME 43 : p3
TIME 44 : p3
TIME 45 : p4
TIME 46 : p4
TIME 47 : p4
TIME 48 : p4
TIME 49 : p2
TIME 50 : p2
TIME 51 : p2
TIME 52 : p2
TIME 53 : p2

Average Waiting Time: 19.0
Average Turn Around Time: 29.4
Utilization Rate: 101.88679245283019%
Throughput: 9.433962264150944% 

If we set time slice to 10 keeping the same arrival time and burst time, we get the following results:

Average Waiting Time: 21.8
Average Turn Around Time: 32.2
Utilization Rate: 101.88679245283019%
Throughput: 9.433962264150944%

Source Code on GitHub: https://github.com/FaisalNahian/CPU_Scheduling_Using_Round_Robin


Comparing both results shows us that as we increase time slice, the average waiting time and turnaround time increases but utilization rate and throughput remains the same.

In conclusion, the need for a scheduling algorithm arises from the requirement of fast computer systems to perform multitasking (execute more than one process at a time) and multiplexing (transmit multiple flows simultaneously). 
Scheduling is a fundamental operating system function that determines which process run, when there are multiple runnable processes. CPU scheduling is important because it impacts resource utilization and other performance parameters. 

There exists a number of CPU scheduling algorithms like First Come First Serve, Shortest Job, First Scheduling, Round Robin scheduling, Priority Scheduling etc, but due to a number of disadvantages these are rarely used in real time operating systems except Round Robin scheduling. 

Some other major features of the Round Robin algorithm is that

•	Throughput is low as the large process is holding up the Central processing unit for execution. 
•	The main advantage of Round robin is to remove starvation. As long as all processes completes the execution then we don’t have any trouble, But the problem starts when any of the process fails to complete. The incomplete execution of any process leads to starvation.
•	Queuing is done without using any prioritization of the processes.




























References:

http://www.cs.rutgers.edu/~pxk/416/notes/07-scheduling.html

http://www.read.seas.harvard.edu/~kohler/class/05s-osp/notes/notes5.html

http://javahungry.blogspot.com/2013/09/round-robin-scheduling-algorithm-with-example-java-program-code.html
