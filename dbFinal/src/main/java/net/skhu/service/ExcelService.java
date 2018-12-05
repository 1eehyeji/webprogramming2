package net.skhu.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import net.skhu.dto.Register;

@Service
public class ExcelService {

	public List<Register> getRegister(InputStream input, String userId) throws Exception {
		List<Register> registers = new ArrayList<>();
		DataFormatter formatter = new DataFormatter();

		// 업로드된 엑셀 파일을 읽기 위한 workbook 객체 생성
		Workbook workbook = WorkbookFactory.create(input);

		// 업로드된 파일의 첫번째 시트를 읽기 위한 sheet 객체 생성
		Sheet sheet = workbook.getSheetAt(0);

		for (int r = 1; r < sheet.getPhysicalNumberOfRows() ; ++r) {
			Row row = sheet.getRow(r);		// r번째 행의 데이터를 읽기 위한 row객체 생성
			if (row.getCell(0) == null) break;		// 데이터가 없으면 읽기를 종료
			String year = formatter.formatCellValue(row.getCell(0));
			String semester = formatter.formatCellValue(row.getCell(1));
			String courseCode = formatter.formatCellValue(row.getCell(2));
			String courseName = formatter.formatCellValue(row.getCell(3));
			String completeDivision = formatter.formatCellValue(row.getCell(4));
			String unit = formatter.formatCellValue(row.getCell(5));
			String credit = formatter.formatCellValue(row.getCell(6));

			// 읽은 데이터로 객체를 생성하여 목록에 추가
			registers.add(new Register(userId, year, semester, courseCode, courseName,
					completeDivision, unit, credit));
		}
		return registers;
	}
}
