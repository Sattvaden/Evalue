# Evalue
Evalue project

## Compilation
```
mvn clean install
```
## Running
```
java -jar target/EvalueTask-1.0.jar <filename>
```
Arguments:
* filename - list of packages

On wrong input error message is printed.

## Testing
```
mvn test
```
gcloud builds submit --tag gcr.io/denis-294317/pubsub:0.1 --project denis-294317
gcloud run deploy pubsub --image gcr.io/denis-294317/pubsub:0.1 --project denis-294317 --platform managed --allow-unauthenticated