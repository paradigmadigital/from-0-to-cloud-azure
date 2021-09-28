1. Execute IAC Pipeline
2. terraform output kubeconfig & Copy to KUBECONFIG Pipeline variable
3. Update eureka cluster DNS & Push changes (deployment.yml)
4. Execute user-service Pipeline
5. Execute category-service Pipeline
6. Execute item-service Pipeline
7. Execute order-service Pipeline
8. Update api gateway cluster DNS & Push changes (deployment.yml)
9. Update frontend cluster DNS & Server Env URL & & Push changes (deployment.yml, server > env > config.js)


### Utils

terraform output -raw kubeconfig > ~/.kube/config