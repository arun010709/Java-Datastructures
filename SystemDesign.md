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
table|
td|
sacrifice|	Why|
td|
td|
td|
td|
td|
td|
td|
td|
td|
td||
generic table with columns: Company, Prioritizes, Sacrifices, Why.
details as provided in the text.
e.g.,
'table>
default table with headers and rows matching the examples provided.
'table>
default table with headers and rows matching the examples provided.
'table>
default table with headers and rows matching the examples provided.
'table>
default table with headers and rows matching the examples provided.
'table>
details as provided in the text.
e.g.,
'table>
default table with headers and rows matching the examples provided.