# Claim Service Health Monitor

A Spring Boot-based health monitoring microservice that provides real-time health and metrics information for the Claims Service ecosystem.

## Features

- **Health Endpoints**: REST API endpoints for service health monitoring
- **Metrics Collection**: JVM, memory, CPU, and custom application metrics via Prometheus
- **Custom Health Indicators**: Database, Claims Service, and external dependency checks
- **Spring Boot Actuator**: Pre-built endpoints for health, metrics, and info
- **Azure Pipelines Integration**: Complete CI/CD pipeline with build, test, and deploy stages
- **Prometheus Metrics Export**: Export metrics for monitoring and alerting
- **Logging**: Structured logging with SLF4J
- **Docker Support**: Multi-stage Docker builds for containerization

## Prerequisites

- Java 11+
- Maven 3.9+
- Docker (optional)
- Azure DevOps account (for CI/CD)

## Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/bhandhuvistu/claim-service-health.git
cd claim-service-health
```

### 2. Build the Project
```bash
mvn clean package
```

### 3. Run Locally
#### Development Mode
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
```

#### Production Mode
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=prod"
```

## API Endpoints

### Health Endpoints

#### GET /api/health
Returns overall health status
```json
{
  "status": "UP",
  "timestamp": "2026-03-30T10:30:00",
  "message": "Overall system health status"
}
```

#### GET /api/health/detailed
Returns detailed health information for all components

#### GET /api/health/claims-service
Returns Claims Service health status

#### GET /api/health/database
Returns Database connectivity status

#### GET /api/health/ready
Returns readiness probe for Kubernetes

#### GET /api/health/live
Returns liveness probe for Kubernetes

### Actuator Endpoints

- Health: `GET /actuator/health`
- Metrics: `GET /actuator/metrics`
- Prometheus Metrics: `GET /actuator/prometheus`
- Application Info: `GET /actuator/info`

## Docker Build and Run

### Build Docker Image
```bash
docker build -t claim-service-health:1.0.0 .
```

### Run Docker Container
```bash
docker run -p 8081:8081 \
  -e SPRING_PROFILES_ACTIVE=prod \
  claim-service-health:1.0.0
```

## Azure Pipelines CI/CD

The project includes a comprehensive Azure Pipelines configuration (`azure-pipelines.yml`) that:

1. **Build Stage**: Compiles code, runs tests, and publishes artifacts
2. **Deploy Dev Stage**: Deploys to development environment
3. **Deploy Prod Stage**: Deploys to production environment

### Setup Azure DevOps

1. Create a new Pipeline in Azure DevOps
2. Connect to this GitHub repository
3. Configure service connections for deployment
4. Create App Services in Azure:
   - `claim-service-health-dev`
   - `claim-service-health-prod`

### Trigger Pipeline

The pipeline automatically triggers on:
- Push to `main` branch
- Push to `develop` branch
- Pull requests to `main`

## Monitoring

### Prometheus Integration

Access Prometheus metrics at: `http://localhost:8081/actuator/prometheus`

**Example Prometheus queries:**
- JVM Memory: `jvm_memory_used_bytes`
- HTTP Requests: `http_server_requests_seconds_count`
- Application Uptime: `process_uptime_seconds`

## Testing

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=HealthControllerTest
```

## Configuration

### Environment Variables

- `SPRING_PROFILES_ACTIVE`: Application profile (dev, prod)
- `JAVA_OPTS`: JVM options (e.g., `-Xmx256m -Xms128m`)

## Troubleshooting

### Application fails to start
```bash
# Check logs
tail -f logs/claim-service-health.log

# Verify Java version
java -version

# Check port availability
lsof -i :8081
```

### Health endpoints not responding
- Verify application is running
- Check port 8081 is accessible
- Review application logs

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see LICENSE file for details

## Support

For issues and questions:
- Create an issue in GitHub
- Contact: nagabhaskar@infinite.com
- Azure DevOps Organization: nagabhaskar@infinite.com
