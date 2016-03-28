package jpabook.jpashop.web;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by sykim on 2016. 3. 27..
 */
@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    /**
     * 상품 목록
     */
    @RequestMapping(value = "/items", method = GET)
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    /**
     * 상품 등록 폼
     */
    @RequestMapping(value = "/items/new", method = GET)
    public String createForm() {
        return "items/createItemForm";
    }

    /**
     * 상품 등록
     */
    @RequestMapping(value = "/items/new", method = POST)
    public String create(Book item) {

        itemService.saveItem(item);
        return "redirect:/items";
    }

    /**
     * 상품 수정 폼
     */
    @RequestMapping(value = "items/{itemId}/edit", method = GET)
    public String updateItemForm(@PathVariable("itemId") Long itemId
            , Model model) {

        Item item = itemService.findOne(itemId);
        model.addAttribute("item", item);
        return "items/updateItemForm";
    }

    /**
     * 상품 수정
     */
    @RequestMapping(value = "items/{itemId}/edit", method = POST)
    public String updateItem(@ModelAttribute("item") Book item) {

        itemService.saveItem(item);
        return "redirect:/items";
    }

}
