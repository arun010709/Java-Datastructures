# SCALED Framework

## S — Scalability
*Can it grow without breaking?*

Scalability is a system's ability to handle increased load by adding resources.

| Type | Description | Example |
|---|---|---|
| Vertical Scaling | Add more power to existing machine (CPU, RAM) | Upgrading server from 8GB to 64GB RAM |
| Horizontal Scaling | Add more machines | Netflix adding more servers during peak hours |

## C — Consistency
*Do all users see the same data at the same time?*

Consistency ensures that every read receives the most recent write.

| Type | Description | Use Case |
|---|---|---|
| Strong Consistency | All nodes see same data instantly | Banking transactions |
| Eventual Consistency | Data syncs eventually, not instantly | Social media likes count |

## A — Availability
*Is the system always there when you need it?*

Availability is measured in "nines":

| Availability | Downtime/Year | Example |
|---|---|---|
| 99% (two nines) | 3.65 days | Personal blog |
| 99.9% (three nines) | 8.76 hours | Business apps |
| 99.99% (four nines) | 52.6 minutes | E-commerce |
| 99.999% (five nines) | 5.26 minutes | Banking, Healthcare |

## L — Latency
*Is it fast enough for users?*

Latency is the time taken for a request to travel from client to server and back.

| Latency | User Perception | Example |
|---|---|---|
| &lt; 100ms | Instant | Google Search |
| 100-300ms | Slight delay | E-commerce checkout |
| 300ms-1s | Noticeable, acceptable for complex queries |
| &gt; 1s | Frustrating, users start leaving |

> Amazon's Discovery: Every 100ms of latency costs 1% in sales.

## E — Efficiency
*Does it use resources wisely?*

Efficiency is about maximizing output while minimizing resource usage (compute, storage, network, cost).

**Metrics:**
- **Throughput:** Requests processed per second 
b- **Resource Utilization:** CPU, Memory, Network usage 
b- **Cost per Request:** Infrastructure cost per operation 

## D — Durability
*Does data stay safe forever?*

durability ensures that once data is saved, it won't be lost — even during failures.

**Strategies:**
- **Replication:** Store copies across multiple servers 
b- **Backups:** Regular snapshots of data 
b- **Write-Ahead Logging:** Log changes before applying them 
b- **Geo-Redundancy:** Store data across different regions 

# More Real-World Examples:
Company,Prioritizes,Sacrifices,Why
SpaceX,Speed & Innovation,Short-term Cost,"Rapid iteration and ""failing fast"" allow for market dominance via reusable tech despite high R&D burn."
Apple,Quality & Design,Affordability (Cost),"Premium positioning ensures high margins and brand loyalty, even if it limits the total addressable market."
Amazon,Speed & Scale,Short-term Profit,"Sacrificing immediate margins for logistics infrastructure builds a competitive ""moat"" that is difficult to replicate."
Toyota,Reliability (Quality),Cutting-edge Features,Prioritizing proven technology over the latest trends ensures long-term vehicle durability and brand trust.
Ryanair / Spirit,Low Cost,Customer Comfort,Stripping away all non-essential services allows for the lowest possible price point for budget-sensitive travelers.

Rate limiter:
1.A rate limiter prevents DoS attacks, intentional or unintentional, by blocking the excess calls.
2.Reduces cost where the system is using a 3rd-party API service and is charged on a per-call-basis.
3.To reduce server load, a rate limiter is used to filter out excess requests caused by bots or users’ misbehaviour.

1.Client-side:
The client is an unreliable place to enforce rate limiting because client requests can easily be forged by malicious actors.

2.Server-side:
Even better than placing it on the server side is to use a rate limiter middleware, which will throttle excess requests even to our server side.

3.Middle-ware:
Like API gateway that sits between front end and server side.

# Storage related HLD questions:
1.What if a distributed lock never releases?
Problem:
If a distributed lock never releases, then other services or processes waiting for that lock may remain blocked indefinitely.
This can slow down the entire workflow and sometimes even stop critical operations completely.
In distributed systems, locks are often used to ensure only one process performs a sensitive operation at a time.
So if the lock gets stuck, many requests may start waiting behind it.

Fix:
Distributed locks are useful, but they must always be designed assuming failures can happen while holding the lock.

So systems should include:
1.Lock expiration
2.Monitoring 
3.Retries
4.Careful timeout handling to prevent the entire workflow from getting blocked because of one stuck lock.

