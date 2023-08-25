package co.yedam.hello.product.mapper;

import java.util.List;

import co.yedam.hello.product.service.ProductVO;

public interface ProductMapper {

	List<ProductVO> productSelectList(); // 전체조회
	
	ProductVO productSelect(ProductVO vo); // 단건조회
	
	int productInsert(ProductVO vo); // 등록
	
	int productUpdate(ProductVO vo); // 수정
	
	int productDelete(ProductVO vo); // 삭제
	
}
