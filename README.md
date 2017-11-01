# MultipleDataSourceJpa
Implementation of Multiple Datasource Jpa in SpringBoot Application

# Starting Application
On Terminal change current directory to project directory then run the following command:
```bash
gradle bRun
```
#### Examples
```bash
curl -X POST \
  http://localhost:8181/employee/save \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
	"firstName":"Racheal",
	"lastName":"Green",
	"salary":1000.00,
	"nationality":"AMERICAN"
}'
curl -X POST \
  http://localhost:8181/employee/save \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
	"firstName":"Anup",
	"lastName":"Yadav",
	"salary":1000.00,
	"nationality":"INDIAN"
}'
curl -X GET \
  http://localhost:8181/employee/1/nationality/INDIAN
```