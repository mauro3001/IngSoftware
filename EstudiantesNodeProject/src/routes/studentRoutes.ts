import { Router } from "express";

import studentController from "../controllers/studentController";

class StudentRoutes {
  public router: Router = Router();

  constructor() {
    this.config();
  }

  config(): void {
    this.router.get("/", studentController.list);
    this.router.get("/:idEstudiante", studentController.getOne);
    this.router.post("/", studentController.create);
  }
}

const studentRoutes = new StudentRoutes();
export default studentRoutes.router;