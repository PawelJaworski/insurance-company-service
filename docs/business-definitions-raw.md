#name tranist time    
#description is the time from the pick up to the arrival. No delivery working hours included.

calculation
GeoIS (PTV)
Driver rule
driving time for one driver: 2:30h driving - 45 min break- 4:30h driving - 11h break -4:30h driving- 45 min break- 4:30h driving - 11h break -(repeat 4:30h driving- 45 min break - 4:30h driving - 11h break)
driving time for 2 drivers 16h driving-9h break -18driving -9h break -(repeat 18 h driving-9h break)
counting from delivery date the 2:30h driving will be the first counted (last driving event on a time range)
non ferry calculation:
for countries with a borderline
A to B calculation
for countries without a borderline
A to A/border - A/border to B
f.e. Warsaw t o Brussels:
Warsaw to Polish/German Border plus Polish/German border to Brussels
ferry calculation:
Transit Time Calculation: Distance Time from start to Departure Ferry Port (incl driver rule) + waiting time to Port Arrival time on Departure Ferry Port + Ferry Opeartion Time to Ready to go on Arrival Ferry port + Distance Time from Arrival Ferry Port to Destination (incl driver rule).
Note: Driver rule is reseted on Arrival Ferry Port.
algorithm finds fastest routes
transit time shows transit time in days rounded down
workdays Mo-Fr are only considered
if pick up or/and delivery or not on workdays, extra days are added to the delivery date
no driving, no pick-up and no delivery on Sat and Sun (global rule that can be changed by a business rule
border waiting time increases transit time
Business rules | driver capacity
Transit time in scheduling is based on calendar working days
working days exclude Saturdays, Sundays and holidays in delivery country
Given I calculate transit time when there is a holiday, the time till midnight is added to the calculation

------------------------------------------------------------------------------------------
#name driver capacity
#description driver is after all necessery breaks while starting a new trip
ferry, train or driving restriction resets the driver rule
To be confirmed if we need to change it to “When time of ferry, train or driving restriction >11h(1driver or 9h for 2 drivers), then count it the driver as made a rest = he made a long break (1 driver 11h/2drivers 9h)”
Driver rule
The rule determines and explains driver work, breaks and how it applies to transit time calculation.
driving time for one driver: 2:30h driving - 45 min break- 4:30h driving - 11h break -4:30h driving- 45 min break- 4:30h driving - 11h break -(repeat 4:30h driving- 45 min break - 4:30h driving - 11h break)
driving time for 2 drivers 16h driving-9h break -18driving -9h break -(repeat 18 h driving-9h break)
The driver starts the travel from 7h driving time. The value is increased to 9h after the second driving break and is applicable to the end of the travel.
Any ferry, train, driving restriction, holiday or working hours (delivery working hours) are treated as a driver's break, no matter how long it takes.
Note: The reason why the driver starts the travel from 7h driving time is explained by business as 2h is the required time to spent in terminal on travel preparation (papers, loading preparation, loading) The drivers is 2h earlier then the pick up time