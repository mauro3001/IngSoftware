import {Request,Response, text} from "express";

import pool from "../database";

class StudenController{
    public async list(req: Request,res: Response){
        const student = await pool.query("SELECT * FROM estudiante");
        res.json(student);
    }

    public async create (req: Request, res: Response): Promise<void>{
        await pool.query("INSERT INTO estudiante set ?", [req.body]);
        res.json({Text: "estudiante creado"});
    }

    public async getOne(req: Request, res: Response): Promise<any>{
        const  {idEstudiante} = req.params;
        const student = await pool.query("SELECT * FROM estudiante WHERE idEstudiante = ?", [idEstudiante]);
        if(student.length > 0){
            return res.json(student[0]);
        }
        res.status(404).json({Text: "student not found"})
    }
}

const studentController = new StudenController();
export default studentController;