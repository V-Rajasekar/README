# SQL Useful queries

## Permformance queries

```sql
--Query to clear connections in idle state
SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE pid <> pg_backend_pid() AND state in ('idle');

Prod:
SELECT pg_terminate_backend(pid)  FROM pg_stat_activity
WHERE pid <> pg_backend_pid()
AND state in ('idle')
AND CAST(client_addr as text) not LIKE '10.10%'
AND usename <> 'azuresu';
```

### Latency of records received
```sql
--Query to find latency in last 1 hour

select cr.customer_nr, cr.updated_timestamp - cr.timestamp_source as diff,cr.updated_timestamp, cr.timestamp_source
from mdm.customer_register cr
where cr.updated_timestamp > current_date - interval '1 hours'
order by diff desc
```
## JSON queries

```sql
-- Querying using JSON expression
-------------------------------------------
select raw_data::jsonb -> 'eventCode' as "Eventcode" ,* 
FROM logs.ph_event_exception_log 
where exception_type='RETRYABLE' and original_timestamp > now() - interval '4 day' 
and marked_for_delete='N' and original_topic like 'ph-oem-eve-consignment-item%' 
and  raw_data::jsonb -> 'eventCode' ='"Q"' ;-
```

## Queries by usecase

```sql

--Self inner join to delete duplicate product with same name, deletes the least product id no
DELETE p1 FROM product  AS p1
INNER JOIN product AS p2
WHERE p1.id < p2.id and p1.name = p2.name;

-- copy tables 
INSERT INTO product_temp SELECT * FROM product
GROUP BY name;
```