resource "kubernetes_deployment" "usedcar_app" {
  metadata {
    name = "usedcar-deployment"
    labels = {
      app = "usedcar"
    }
  }

  spec {
    replicas = 2 # High Availability: Runs 2 copies of your app
    selector {
      match_labels = {
        app = "usedcar"
      }
    }

    template {
      metadata {
        labels = {
          app = "usedcar"
        }
      }

      spec {
        container {
          image = "YOUR_DOCKER_ID/used-car-app:v1" # <--- REPLACE WITH YOUR ID
          name  = "usedcar-container"
          port {
            container_port = 8080
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "usedcar_service" {
  metadata {
    name = "usedcar-service"
  }
  spec {
    selector = {
      app = "usedcar"
    }
    port {
      port        = 80
      target_port = 8080
    }
    type = "LoadBalancer" # This gives you a public IP
  }
}