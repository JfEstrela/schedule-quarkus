# schedule-quarkus


## Creating the Maven project Quarkus
First, we need a new project. Create a new project with the following command

```
mvn io.quarkus:quarkus-maven-plugin:0.16.1:create \
    -DprojectGroupId=org.acme \
    -DprojectArtifactId=scheduling-periodic-tasks \
    -DclassName="org.acme.scheduling.CountResource" \
    -Dpath="/count" \
    -Dextensions="scheduler"
    
```

## Running your project Quarkus

```
./mvnw compile quarkus:dev:

```

## EndPoints

### EndPoint Schedule Count Time
```java

    @Inject
    private ScheduleService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/time")
    public String get() {
        return "Schedule Count Time : ".concat(service.getScheduleCountTime().toString());
    }
    
    
```

### EndPoint Schedule Count Cron

```java

    @Inject 
    private ScheduleService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/cron")
    public String helloApresentation() {
      return "Schedule Count Cron :".concat(service.getScheduleCountCron().toString());
    }
    
```


#### ScheduleService

```java

@ApplicationScoped
public class ScheduleService {

	private AtomicInteger scheduleCountTime = new AtomicInteger();
	private AtomicInteger scheduleCountCron = new AtomicInteger();
	
	public Integer getScheduleCountTime() {
		return scheduleCountTime.get();
	}
	
	public Integer getScheduleCountCron() {
		return scheduleCountCron.get();
	}
	
	@Scheduled(every="5s")
	void incrementScheduleCountCron() {
		scheduleCountCron.incrementAndGet();
	}
	
	@Scheduled(cron="*/5 * * * * ?")
	void incrementScheduleCountTime() {
		scheduleCountTime.incrementAndGet();
	}
}
```


## Reference Documentation
For further reference, please consider the following sections:

* [SCHEDULED GUIDE](https://quarkus.io/guides/scheduled-guide)
