package co.yedam.hello.menu;

import java.util.List;
import java.util.Scanner;

import co.yedam.hello.product.service.ProductService;
import co.yedam.hello.product.service.ProductServiceImpl;
import co.yedam.hello.product.service.ProductVO;

public class ProductManager {
	
	private final Scanner scn = new Scanner(System.in);
	
	private final ProductService productService = new ProductServiceImpl();
	
	
	public void run() {
		boolean exit = false;
		
		do {
			mainTitle();
			int mainMenu = scn.nextInt(); 
			scn.nextLine();
			switch (mainMenu) {
				case 1:
					showProductList();
					break;
				case 2:
					showProduct();
					break;
				case 3:
					insertProduct();
					break;
				case 4:
					updateProduct();
					break;
				case 5:
					deleteProduct();
					break;
				case 6:
					exit = true;
					System.out.println("프로그램이 종료됩니다...");
					scn.close();
					break;
				default:
					break;
			}
			System.out.println("\n\n");
		} while (!exit);
	}
	
	private void mainTitle() {
		System.out.println("=======================");
		System.out.println("      <제 품 관 리>      ");
		System.out.println("=======================");
		System.out.println("    1. 제품 전체조회");
		System.out.println("    2. 제품 단건조회");
		System.out.println("    3. 제품 등록");
		System.out.println("    4. 제품 수정");
		System.out.println("    5. 제품 삭제");
		System.out.println("    6. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}

	private void showProductList() {
		System.out.println("----------------");
		System.out.println(" 제품 전체조회 입니다");
		System.out.println("----------------");
		
		List<ProductVO> products = productService.productSelectList();
		
		System.out.println("--------------------------------------------------");
		for (ProductVO vo : products) {
			System.out.println(vo);
		}
		System.out.println("--------------------------------------------------");
	}
	
	private void showProduct() {
		System.out.println("----------------");
		System.out.println(" 제품 단건조회 입니다");
		System.out.println("----------------");
		
		System.out.println("제품코드 >>");
		String targetCode = scn.nextLine();
		
		ProductVO vo = new ProductVO();
		vo.setProductId(targetCode);
		
		ProductVO selectedVo = productService.productSelect(vo);
		System.out.println(selectedVo);
	}
	
	private void insertProduct() {
		System.out.println("----------------");
		System.out.println("  제품 등록 입니다");
		System.out.println("----------------");
		
		System.out.println("제품코드 >>");
		String code = scn.nextLine();
		
		System.out.println("제품명 >>");
		String name = scn.nextLine();
		
		System.out.println("제품가격 >>");
		int price = scn.nextInt();
		scn.nextLine();
		
		System.out.println("모델명 >>");
		String model = scn.nextLine();
		
		ProductVO vo = new ProductVO(code, name, price, model);
		int numIns = productService.productInsert(vo);
		if (numIns != 0) {
			System.out.println("등록 완료!");
		} else {
			System.out.println("등록 실패.");
		}
	}
	
	private void updateProduct() {
		System.out.println("----------------");
		System.out.println("  제품 수정 입니다");
		System.out.println("----------------");
		
		System.out.println("수정대상 제품코드 >>");
		String targetCode = scn.nextLine();
		
		updateTitle();
		int updateMenu = scn.nextInt(); 
		scn.nextLine();
		
		switch (updateMenu) {
			case 1:
				updateProductAllAttr(targetCode);
				break;
			case 2:
				updateProductName(targetCode);
				break;
			case 3:
				updateProductPrice(targetCode);
				break;
			case 4:
				updateProductModel(targetCode);
				break;
			default:
				break;
		}	
	}
	
	private void updateTitle() {
		System.out.println("----------------");
		System.out.println("   -수 정 항 목-");
		System.out.println("----------------");
		System.out.println("    1. 모든항목");
		System.out.println("    2. 제품명");
		System.out.println("    3. 제품가격");
		System.out.println("    4. 모델명");
		System.out.println("----------------");
		System.out.println("항목을 선택하세요 >>");
	}
	
	private void updateProductAllAttr(String code) {
		System.out.println("----------------");
		System.out.println(" 모든항목 수정 입니다");
		System.out.println("----------------");
		
		System.out.println("수정 제품명 >>");
		String newName = scn.nextLine();
		
		System.out.println("수정 제품가격 >>");
		int newPrice = scn.nextInt();
		scn.nextLine();
		
		System.out.println("수정 모델명 >>");
		String newModel = scn.nextLine();
		
		ProductVO updateDto = new ProductVO(code, newName, newPrice, newModel);
		int numUpd = productService.productUpdate(updateDto);
		if (numUpd != 0) {
			System.out.println("수정 완료!");
		} else {
			System.out.println("수정 실패.");
		}
	}
	
	private void updateProductName(String code) {
		System.out.println("----------------");
		System.out.println("  제품명 수정 입니다");
		System.out.println("----------------");
		
		System.out.println("수정 제품명 >>");
		String newName = scn.nextLine();
		
		ProductVO updateDto = new ProductVO(code, newName, 0, null);
		int numUpd = productService.productUpdate(updateDto);
		if (numUpd != 0) {
			System.out.println("수정 완료!");
		} else {
			System.out.println("수정 실패.");
		}
	}
	
	private void updateProductPrice(String code) {
		System.out.println("----------------");
		System.out.println(" 제품가격 수정 입니다");
		System.out.println("----------------");
		
		System.out.println("수정 제품가격 >>");
		int newPrice = scn.nextInt();
		scn.nextLine();
		
		ProductVO updateDto = new ProductVO(code, null, newPrice, null);
		int numUpd = productService.productUpdate(updateDto);
		if (numUpd != 0) {
			System.out.println("수정 완료!");
		} else {
			System.out.println("수정 실패.");
		}
	}
	
	private void updateProductModel(String code) {
		System.out.println("----------------");
		System.out.println("  모델명 수정 입니다");
		System.out.println("----------------");
		
		System.out.println("수정 모델명 >>");
		String newModel = scn.nextLine();
		
		ProductVO updateDto = new ProductVO(code, null, 0, newModel);
		int numUpd = productService.productUpdate(updateDto);
		if (numUpd != 0) {
			System.out.println("수정 완료!");
		} else {
			System.out.println("수정 실패.");
		}
	}

	private void deleteProduct() {
		System.out.println("----------------");
		System.out.println("  제품 삭제 입니다");
		System.out.println("----------------");
		
		System.out.println("삭제대상 제품코드 >>");
		String targetCode = scn.nextLine();
		
		ProductVO vo = new ProductVO();
		vo.setProductId(targetCode);
		int numDel = productService.productDelete(vo);
		if (numDel != 0) {
			System.out.println("삭제 완료!");
		} else {
			System.out.println("삭제 실패.");
		}
	}

}
