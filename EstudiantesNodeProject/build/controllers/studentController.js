"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const database_1 = __importDefault(require("../database"));
class StudenController {
    list(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const student = yield database_1.default.query("SELECT * FROM estudiante");
            res.json(student);
        });
    }
    create(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            yield database_1.default.query("INSERT INTO estudiante set ?", [req.body]);
            res.json({ Text: "estudiante creado" });
        });
    }
    getOne(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const { idEstudiante } = req.params;
            const student = yield database_1.default.query("SELECT * FROM estudiante WHERE idEstudiante = ?", [idEstudiante]);
            if (student.length > 0) {
                return res.json(student[0]);
            }
            res.status(404).json({ Text: "student not found" });
        });
    }
}
const studentController = new StudenController();
exports.default = studentController;
