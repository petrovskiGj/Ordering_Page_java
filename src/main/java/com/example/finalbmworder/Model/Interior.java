package com.example.finalbmworder.Model;


import com.example.finalbmworder.Model.Enum.InteriorSeatType;
import com.example.finalbmworder.Model.Enum.InteriorTrimType;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Interior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photoTrim;
    private String photoSeat;
    private String name;
    @Enumerated(EnumType.STRING)
    private InteriorTrimType trimType;
    @Enumerated(EnumType.STRING)
    private InteriorSeatType seatType;
    private String colors;
    private Integer markPopular=0;


}
